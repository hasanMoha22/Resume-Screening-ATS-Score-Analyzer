import React from "react";

export default function JobDescriptionInput({ jdText, setJdText }) {
  return (
    <div className="card">
      <h3>📄 Job Description</h3>
      <textarea
        rows="8"
        placeholder="Paste the job description here..."
        value={jdText}
        onChange={(e) => setJdText(e.target.value)}
        style={{
          width: "100%",
          padding: "12px",
          borderRadius: "10px",
          border: "1px solid #cbd5e1",
          fontSize: "14px",
        }}
      />
    </div>
  );
}
