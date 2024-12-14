// TeacherTable.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './TeacherTable.css';

const TeacherTable = () => {
  const [substitutions, setSubstitutions] = useState([]);

  useEffect(() => {
    // Fetching substitution data from backend API
    axios.get('http://localhost:8080/api/substitutions')
      .then(response => setSubstitutions(response.data))
      .catch(error => console.error('Error fetching substitution data:', error));
  }, []);

  return (
    <div className="table-container">
      <h1 className="table-title">Substitution Schedule</h1>
      <table className="teacher-table">
        <thead>
          <tr>
            <th>Substitution ID</th>
            <th>Absent Teacher ID</th>
            <th>Substitute Teacher ID</th>
            <th>Class ID</th>
            <th>Period Number</th>
            <th>Date</th>
          </tr>
        </thead>
        <tbody>
          {substitutions.map((substitution, index) => (
            <tr key={index} className="table-row">
              <td>{substitution.substitution_id}</td>
              <td>{substitution.absent_t_id}</td>
              <td>{substitution.subs_t_id}</td>
              <td>{substitution.class_id}</td>
              <td>{substitution.prd_number}</td>
              <td>{substitution.date}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TeacherTable;
