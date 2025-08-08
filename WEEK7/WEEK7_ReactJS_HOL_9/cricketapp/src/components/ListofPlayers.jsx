import React from 'react';

const players = [
  { name: 'Rohit Sharma', score: 88 },
  { name: 'Shubman Gill', score: 42 },
  { name: 'Virat Kohli', score: 75 },
  { name: 'Shreyas Iyer', score: 66 },
  { name: 'KL Rahul', score: 39 },
  { name: 'Suryakumar Yadav', score: 91 },
  { name: 'Hardik Pandya', score: 35 },
  { name: 'Ravindra Jadeja', score: 58 },
  { name: 'R Ashwin', score: 22 },
  { name: 'Jasprit Bumrah', score: 12 },
  { name: 'Mohammed Shami', score: 18 }
];

export default function ListofPlayers() {
  const belowSeventy = players.filter(p => p.score < 70);
  return (
    <div>
      <h2>Players (score &lt; 70)</h2>
      <ul>
        {belowSeventy.map((p, idx) => (
          <li key={idx}>{p.name} — {p.score}</li>
        ))}
      </ul>
    </div>
  );
}
