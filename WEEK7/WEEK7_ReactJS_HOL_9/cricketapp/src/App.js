import React, { useState } from 'react';
import IndianPlayers from './components/IndianPlayers';
import ListofPlayers from './components/ListofPlayers';

export default function App() {
  const [flag, setFlag] = useState(true);
  return (
    <div style={{ padding: 16 }}>
      <h1>cricketapp</h1>
      <button onClick={() => setFlag(f => !f)}>Toggle View</button>
      {flag ? <ListofPlayers /> : <IndianPlayers />}
    </div>
  );
}
