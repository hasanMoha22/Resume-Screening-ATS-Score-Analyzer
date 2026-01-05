import React, { useEffect, useState } from "react";
import axios from "axios";
import "./ResumeHistory.css";

export default function ResumeHistory() {
  const [history, setHistory] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/api/history")
      .then(res => setHistory(res.data.reverse()))
      .catch(err => console.error(err));
  }, []);

  if (history.length === 0) {
    return <p>No resume history yet</p>;
  }

  return (
    <div className="history-card">
      <h3>📊 Resume Analysis History</h3>

      <table>
        <thead>
          <tr>
            <th>Filename</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Score</th>
            <th>Date</th>
          </tr>
        </thead>
        <tbody>
          {history.map(h => (
            <tr key={h.id}>
              <td>{h.filename}</td>
              <td>{h.email}</td>
              <td>{h.phone}</td>
              <td>{h.score}%</td>
              <td>{h.createdAt?.split("T")[0]}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
