import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore() {
<<<<<<< HEAD
  const name = "Aarav Sharma";
  const school = "Delhi Public School";
  const total = 485;
=======
  const name = "Riya";
  const school = "St. Xavier's School";
  const total = 470;
>>>>>>> ecee5d83082a822f560f400800c3441d9e0f50ad
  const goal = 500;

  const average = (total / goal) * 100;

  return (
    <div className="score-card">
<<<<<<< HEAD
      <h2>Academic Performance Tracker</h2>
      <p><strong>Student Name:</strong> {name}</p>
      <p><strong>Institution:</strong> {school}</p>
      <p><strong>Current Score:</strong> {total}</p>
      <p><strong>Target Score:</strong> {goal}</p>
      <p><strong>Performance Percentage:</strong> {average.toFixed(2)}%</p>
=======
      <h2>Student Score Calculator</h2>
      <p><strong>Name:</strong> {name}</p>
      <p><strong>School:</strong> {school}</p>
      <p><strong>Total Marks:</strong> {total}</p>
      <p><strong>Goal Marks:</strong> {goal}</p>
      <p><strong>Average Score:</strong> {average.toFixed(2)}%</p>
>>>>>>> ecee5d83082a822f560f400800c3441d9e0f50ad
    </div>
  );
}

export default CalculateScore;
