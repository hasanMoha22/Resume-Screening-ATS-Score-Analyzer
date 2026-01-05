package com.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.boot.entity.AnalysisHistory;
import com.boot.helper.pdfScanner;
import com.boot.helper.wordFinder;
import com.boot.repository.AnalysisHistoryRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class Controller {

    @Autowired
    private AnalysisHistoryRepository historyRepo;

    @Autowired
    private pdfScanner pdfScanner;

    @Autowired
    private wordFinder wordFinder;

    /* ===============================
       POST : Analyze Resume + Save History
       =============================== */
    @PostMapping("/upload-file")
    public Map<String, Object> uploadFile(
            @RequestParam("pdf") MultipartFile file,
            @RequestParam("options") List<String> skills) throws Exception {

        // 1️⃣ Extract text from PDF
        String text = pdfScanner.scan(file);

        // 2️⃣ Analyze skills
        Map<String, Object> analysis = wordFinder.analyzeSkills(text, skills);

        // 3️⃣ Extract email & phone (STRING, not List)
        String email = wordFinder.findEmail(text);
        String phone = wordFinder.findPhone(text);

        // 4️⃣ Save analysis history
        AnalysisHistory history = new AnalysisHistory();
        history.setFilename(file.getOriginalFilename());
        history.setEmail(email);
        history.setPhone(phone);
        history.setScore(
                analysis.get("score") != null ? (Double) analysis.get("score") : 0.0
        );
        history.setMatchedSkills(
                (List<String>) analysis.getOrDefault("matchedSkills", List.of())
        );
        history.setMissingSkills(
                (List<String>) analysis.getOrDefault("missingSkills", List.of())
        );

        historyRepo.save(history);

        // 5️⃣ API Response (Frontend-friendly)
        Map<String, Object> response = new HashMap<>();
        response.put("analysis", analysis);
        response.put("historyId", history.getId());
        response.put("filename", history.getFilename());
        response.put("email", email);
        response.put("phone", phone);
        response.put("score", history.getScore());

        return response;
    }

    /* ===============================
       GET : Fetch Resume Analysis History
       =============================== */
    @GetMapping("/history")
    public List<AnalysisHistory> getAnalysisHistory() {
        return historyRepo.findAll();
    }
}
