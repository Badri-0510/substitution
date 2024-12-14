import React, { useState } from 'react';
import axios from 'axios';
import './TeacherAttendance.css';

const TeacherAttendance = () => {
  const initialTeachers = [
    { id: 101, name: "Dhanabagyam", isPresent: false, isAbsent: false },
    { id: 102, name: "Indhumathi", isPresent: false, isAbsent: false },
    { id: 103, name: "Jayanthi", isPresent: false, isAbsent: false },
    { id: 104, name: "Subathra Devi", isPresent: false, isAbsent: false },
    { id: 105, name: "Subha", isPresent: false, isAbsent: false },
    { id: 106, name: "Praveena", isPresent: false, isAbsent: false },
    { id: 107, name: "Sheela Devi", isPresent: false, isAbsent: false },
    { id: 108, name: "Prabhu", isPresent: false, isAbsent: false },
    { id: 109, name: "Gowtham", isPresent: false, isAbsent: false },
    { id: 110, name: "Durgadevi", isPresent: false, isAbsent: false },
  ];

  const [teachers, setTeachers] = useState(initialTeachers);
  const [selectedDay, setSelectedDay] = useState('');
  const [dayOfWeek, setDayOfWeek] = useState('');
  const [attendanceData, setAttendanceData] = useState([]);

  const daysOfWeek = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];

  const handleDateChange = (event) => {
    const date = new Date(event.target.value);
    setSelectedDay(event.target.value);
    setDayOfWeek(daysOfWeek[date.getDay()]);
    console.log(`Selected Day: ${daysOfWeek[date.getDay()]}`);
  };

  const markAbsent = (teacherId) => {
    console.log(`Marking teacher ID ${teacherId} as absent`);

    // Mark the teacher as absent
    setTeachers(teachers.map(teacher =>
      teacher.id === teacherId ? { ...teacher, isAbsent: true, isPresent: false } : teacher
    ));

    // Update the attendance data with the correct day for each teacher
    const updatedAttendance = teachers.map(teacher =>
      teacher.id === teacherId
        ? { teacher_id: teacher.id, day: dayOfWeek }  // Store the correct day along with teacher_id
        : teacher
    );

    // Filter out only the marked teachers for attendance submission
    const attendanceToSubmit = updatedAttendance.filter(attendance => attendance.teacher_id === teacherId);
    
    // Log the attendance data for debugging
    console.log('Updated Attendance Data:', attendanceToSubmit);

    // Add the updated attendance to state
    setAttendanceData(prevData => [...prevData, ...attendanceToSubmit]);
  };

  const handleSubmit = async () => {
    if (!selectedDay) {
      alert("Please select a day before submitting attendance.");
      return;
    }
  
    // Log the data being sent for debugging
    console.log('Attendance Data to Submit:', attendanceData);
  
    try {
      // Send each attendance item individually
      for (const attendance of attendanceData) {
        // Send a POST request for each attendance
        await axios.post('http://localhost:8080/teachersatt/update', attendance);
        console.log(`Attendance for teacher ID ${attendance.teacher_id} on ${attendance.day} updated successfully.`);
      }
  
      // Now that attendance data is submitted, call the substitution API
      await axios.post('http://localhost:8080/teachersatt/substitution', null, {
        params: {
          day: dayOfWeek  // Pass the day as a query parameter
        }
      });
      console.log('Substitution generated');
  
      alert('Attendance submitted successfully!');
    } catch (error) {
      console.error('Error in submitting attendance or generating substitution:', error);
      alert('There was an error while submitting attendance. Please try again.');
    }
  };
  
  return (
    <div className="attendance-container">
      <h1 className="title">Teacher Attendance</h1>

      {/* Day Selector */}
      <div className="day-selector">
        <label htmlFor="day">Select Day: </label>
        <input
          type="date"
          id="day"
          value={selectedDay}
          onChange={handleDateChange}
        />
      </div>

      {/* Teacher List */}
      <ul className="teacher-list">
        {teachers.map(teacher => (
          <li key={teacher.id} className={`teacher-item ${teacher.isPresent ? 'present' : teacher.isAbsent ? 'absent' : ''}`}>
            {teacher.name} (ID: {teacher.id})
            {teacher.isPresent ? (
              <span className="status present-status">Present</span>
            ) : teacher.isAbsent ? (
              <span className="status absent-status">Absent</span>
            ) : (
              <div className="button-group">
                <button
                  className="mark-button absent-button"
                  onClick={() => markAbsent(teacher.id)}
                  disabled={teacher.isAbsent}  // Disable if already marked absent
                >
                  {teacher.isAbsent ? 'Marked Absent' : 'Mark Absent'}
                </button>
              </div>
            )}
          </li>
        ))}
      </ul>

      {/* Submit Button */}
      <div className="submit-container">
        <button className="submit-button" onClick={handleSubmit}>Submit Attendance</button>
      </div>
    </div>
  );
};

export default TeacherAttendance;
