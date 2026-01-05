import React from "react";
import logo from "./main.png";

export default function Header() {
  return (
    <div>
      <div className="header">
        <img src={logo} alt="Logo" style={{
          maxWidth: '100%', 
          width: '150px',   
          height: 'auto',   
        }}/>
      </div>
      <div className="card">
        <center>
          <h1>Hasan Resume Screening Website</h1>
        </center>
      </div>
    </div>
  );
}
