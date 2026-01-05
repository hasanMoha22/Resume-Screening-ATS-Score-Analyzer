package com.boot.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "analysis_history")
public class AnalysisHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filename;
    private String email;
    private String phone;

    @Column(nullable = false)
    private Double score;

    @ElementCollection
    @CollectionTable(name = "matched_skills", joinColumns = @JoinColumn(name = "history_id"))
    @Column(name = "skill")
    private List<String> matchedSkills;

    @ElementCollection
    @CollectionTable(name = "missing_skills", joinColumns = @JoinColumn(name = "history_id"))
    @Column(name = "skill")
    private List<String> missingSkills;

    private LocalDateTime createdAt = LocalDateTime.now();

    /* ===== Getters & Setters ===== */

    public Long getId() { return id; }

    public String getFilename() { return filename; }
    public void setFilename(String filename) { this.filename = filename; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public List<String> getMatchedSkills() { return matchedSkills; }
    public void setMatchedSkills(List<String> matchedSkills) {
        this.matchedSkills = matchedSkills;
    }

    public List<String> getMissingSkills() { return missingSkills; }
    public void setMissingSkills(List<String> missingSkills) {
        this.missingSkills = missingSkills;
    }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
