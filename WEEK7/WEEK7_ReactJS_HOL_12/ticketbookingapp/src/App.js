import React, { useState } from 'react';

function FlightsList() {
  const flights = [
    { id: 1, route: 'BLR → BOM', time: '10:30', price: 5800 },
    { id: 2, route: 'DEL → HYD', time: '12:15', price: 4900 },
  ];
  return (
    <div>
      <h3>Available Flights</h3>
      <ul>
        {flights.map(f => (
          <li key={f.id}>{f.route} — {f.time} — ₹{f.price}</li>
        ))}
      </ul>
    </div>
  );
}

function GuestPage() {
  return (
    <div>
      <h2>Guest</h2>
      <p>You can browse flights, please login to book tickets.</p>
      <FlightsList />
    </div>
  );
}

function UserPage() {
  const [selected, setSelected] = useState('BLR → BOM');
  return (
    <div>
      <h2>User</h2>
      <FlightsList />
      <div style={{ marginTop: 16 }}>
        <label>
          Select Flight:
          <select value={selected} onChange={e => setSelected(e.target.value)} style={{ marginLeft: 8 }}>
            <option>BLR → BOM</option>
            <option>DEL → HYD</option>
          </select>
        </label>
        <button style={{ marginLeft: 8 }} onClick={() => alert(`Booked: ${selected}`)}>Book</button>
      </div>
    </div>
  );
}

export default function App() {
  const [loggedIn, setLoggedIn] = useState(false);
  return (
    <div style={{ padding: 16 }}>
      <h1>ticketbookingapp</h1>
      {loggedIn ? <UserPage /> : <GuestPage />}
      <div style={{ marginTop: 16 }}>
        {loggedIn ? (
          <button onClick={() => setLoggedIn(false)}>Logout</button>
        ) : (
          <button onClick={() => setLoggedIn(true)}>Login</button>
        )}
      </div>
    </div>
  );
}
