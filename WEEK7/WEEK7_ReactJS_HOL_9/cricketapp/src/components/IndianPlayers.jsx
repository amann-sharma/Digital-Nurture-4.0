import React from 'react';

export default function IndianPlayers() {
  const oddTeam = ['Rohit', 'Virat', 'SKY', 'Jadeja', 'Bumrah'];
  const evenTeam = ['Gill', 'Iyer', 'Rahul', 'Ashwin', 'Shami'];

  const [captain, ...restOdd] = oddTeam;
  const [viceCaptain, ...restEven] = evenTeam;

  const t20Players = ['Rohit', 'Virat', 'Gill'];
  const ranjiPlayers = ['Shaw', 'Sarfaraz', 'Jaiswal'];
  const merged = [...t20Players, ...ranjiPlayers];

  return (
    <div>
      <h2>Indian Players — Odd/Even Teams</h2>
      <p>Odd team captain: {captain}</p>
      <p>Odd team members: {restOdd.join(', ')}</p>
      <p>Even team vice-captain: {viceCaptain}</p>
      <p>Even team members: {restEven.join(', ')}</p>

      <h3>Merged Players (T20 + Ranji Trophy)</h3>
      <ul>
        {merged.map((n, i) => (<li key={i}>{n}</li>))}
      </ul>
    </div>
  );
}
