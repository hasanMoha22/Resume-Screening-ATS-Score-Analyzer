export default function ResultDisplay({ data }) {
  return (
    <div className="card">
      <h3>📄 Resume Analysis Result</h3>

      <p><strong>Filename:</strong> {data.filename}</p>
      <p><strong>Email:</strong> {data.email}</p>
      <p><strong>Phone:</strong> {data.phone}</p>

      <h4>Score: {data.score}%</h4>

      <h4>Matched Skills</h4>
      <p>{data.analysis.matchedSkills.join(", ")}</p>

      <h4>Missing Skills</h4>
      <p>{data.analysis.missingSkills.join(", ")}</p>
    </div>
  );
}
