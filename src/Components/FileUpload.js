import React, { useState } from "react";
import axios from "axios";
import Select from "react-select";
import "./DropdownMenu.css";
import options from "./Options";
import ResultDisplay from "./ResultDisplay";

const API_URL = "http://localhost:8080/api/upload-file";

export default function FileUpload() {
  const [responseData, setResponseData] = useState(null);
  const [selectedFile, setSelectedFile] = useState(null);
  const [selectedOptions, setSelectedOptions] = useState([]);
  
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleFileChange = (e) => {
    setSelectedFile(e.target.files[0]);
    setError("");
  };

  const handleOptionChange = (selected) => {
    setSelectedOptions(selected || []);
  };

  const handleSubmit = async () => {
    if (!selectedFile || selectedOptions.length === 0) {
      setError("Please upload resume and select skills");
      return;
    }

    const formData = new FormData();
    formData.append("pdf", selectedFile);
    formData.append(
      "options",
      selectedOptions.map((o) => o.value)
    );

    try {
      setLoading(true);

      const res = await axios.post(API_URL, formData);

      setResponseData(res.data);

    } catch (err) {
      setError("Resume analysis failed");
    } finally {
      setLoading(false);
    }
  };

  return (
    <>
      <div className="card">
        <h2>Upload Resume</h2>

        <input type="file" accept=".pdf" onChange={handleFileChange} />

        <Select
          isMulti
          options={options}
          value={selectedOptions}
          onChange={handleOptionChange}
          placeholder="Select skills"
        />

        <button onClick={handleSubmit} disabled={loading}>
          {loading ? "Analyzing..." : "Analyze Resume"}
        </button>

        {error && <p style={{ color: "red" }}>{error}</p>}
      </div>

      {/* ✅ RESULT DISPLAY */}
      {responseData && (
        <ResultDisplay data={responseData} />
      )}
    </>
  );
}
