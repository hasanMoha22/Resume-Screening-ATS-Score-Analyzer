import React from "react";
import logo from "./demo.jpg";

export default function Footer() {
  return (
    <footer>
      <div className="footer-container">
        <img
          src={logo}
          alt="Logo"
          style={{
            maxWidth: "100%",
            width: "120px",
            height: "auto",
          }}
        />
      </div>

      <p className="footer-text">
        Developed By: Hasan Mohamed M 2025ⓒ <br />
        Email:{" "}
        <a href="mailto:mhasanmoha22@gmail.com">
          mhasanmoha22@gmail.com
        </a>
      </p>
    </footer>
  );
}
