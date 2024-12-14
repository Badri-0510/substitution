import React from 'react';
import { useNavigate } from 'react-router-dom';
import './HomePage.css';

const HomePage = () => {
  const navigate = useNavigate();

  const handleNavigate = (path) => {
    navigate(path);
  };

  return (
    <div className="homepage">
      {/* Header Section */}
      <header className="header">
        <h1>Substitution Allotment</h1>
        <p>
          Efficiently manage substitutions and streamline daily school operations for enhanced educational quality and staff satisfaction.
        </p>
      </header>

      {/* About Section */}
      <section className="about-section">
        <h2>About Our System</h2>
        <p>
          Our substitution management system is designed to automate and optimize the process of assigning substitute teachers based on real-time availability, subject expertise, and workload balance. Built for school administrators, teachers, and students, it ensures fair substitution allocations and reduces the operational disruptions caused by teacher absences. With a seamless interface and intelligent algorithms, our system aims to improve scheduling efficiency, maintain educational continuity, and enhance staff morale.
        </p>
      </section>

      {/* Features Section */}
      <section className="features-section">
        <h2>Key Features</h2>
        <p>
          - Manage attendance with ease<br />
          - User-friendly interface<br />
          - Flexible scheduling for  teachers
        </p>
      </section>

      {/* Menu Section */}
      <section className="menu-section">
        <button onClick={() => handleNavigate('/attendance')} className="menu-button">
          Report Attendance 
        </button>
        <button onClick={() => handleNavigate('/teachertable')} className="menu-button">
          View Substitution Datails
        </button>
      </section>

      {/* Footer Section */}
      <footer className="footer">
        <h3>Contact Us</h3>
        <p>
        <a href="mailto:subhik60@gmail.com">
      Email: info@substitutionallotment.com
      </a>
      </p>
      <p>
    <a href="tel:7558135061" className="contact-link">
      Phone: (123) 456-7890
    </a>
  </p>
      </footer>
    </div>
  );
};

export default HomePage;