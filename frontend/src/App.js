// App.js

import React from 'react';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePage from './HomePage'; // Import your HomePage component
import TeacherAttendance from './TeacherAttendance'; // Import your TeacherAttendance component
import TeacherTable from './TeacherTable';

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<HomePage />} /> {/* HomePage will be shown at the root path */}
        <Route path="/attendance" element={<TeacherAttendance />} /> {/* TeacherAttendance page */}
        <Route path="/teachertable" element={<TeacherTable />} />
      </Routes>
    </Router>
  );
};

export default App;
