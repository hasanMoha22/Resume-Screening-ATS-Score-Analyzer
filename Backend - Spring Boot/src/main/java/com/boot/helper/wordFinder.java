package com.boot.helper;

import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.*;
import org.springframework.stereotype.Component;

@Component
public class wordFinder {

    /* ================= EMAIL ================= */
    public String findEmail(String text) {
        Pattern pattern = Pattern.compile(
            "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b"
        );
        Matcher matcher = pattern.matcher(text);

        return matcher.find() ? matcher.group() : "Not Found";
    }

    /* ================= PHONE ================= */
    public String findPhone(String text) {

        // Remove line breaks & extra spaces
        String cleanedText = text.replaceAll("\\s+", " ");

        Pattern pattern = Pattern.compile(
            "(\\+91[- ]?)?[6-9]\\d{9}"
        );

        Matcher matcher = pattern.matcher(cleanedText);

        if (matcher.find()) {
            return matcher.group();
        }

        return "Not Found";
    }


    /* ================= SKILL ANALYSIS ================= */
    public Map<String, Object> analyzeSkills(String resumeText, List<String> skills) {

        Map<String, Object> result = new HashMap<>();

        String cleanedText = resumeText
                .replaceAll("[^a-zA-Z ]", " ")
                .toLowerCase();

        String[] words = cleanedText.split("\\s+");

        List<String> matchedSkills = new ArrayList<>();
        List<String> missingSkills = new ArrayList<>();
        Map<String, Integer> skillFrequency = new HashMap<>();

        int totalMatches = 0;

        for (String skill : skills) {
            String skillLower = skill.toLowerCase();
            int count = 0;

            for (String word : words) {
                if (word.equals(skillLower)) count++;
            }

            skillFrequency.put(skill, count);

            if (count > 0) {
                matchedSkills.add(skill);
                totalMatches += count;
            } else {
                missingSkills.add(skill);
            }
        }

        double coverageScore = ((double) matchedSkills.size() / skills.size()) * 70;
        double frequencyScore = Math.min(30, totalMatches * 2);
        double finalScore = coverageScore + frequencyScore;

        result.put("score", Double.parseDouble(new DecimalFormat("#.##").format(finalScore)));
        result.put("matchedSkills", matchedSkills);
        result.put("missingSkills", missingSkills);
        result.put("skillFrequency", skillFrequency);
        result.put("totalSkills", skills.size());
        result.put("matchedCount", matchedSkills.size());

        return result;
    }
}
