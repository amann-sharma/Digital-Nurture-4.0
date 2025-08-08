import React from 'react';

const offices = [
  { name: 'Prime Tower', rent: 55000, address: 'MG Road, Bengaluru', image: 'https://via.placeholder.com/320x180?text=Office+1' },
  { name: 'Tech Park', rent: 78000, address: 'Hinjewadi, Pune', image: 'https://via.placeholder.com/320x180?text=Office+2' },
  { name: 'Skyline Plaza', rent: 62000, address: 'BKC, Mumbai', image: 'https://via.placeholder.com/320x180?text=Office+3' }
];

export default function App() {
  const heading = <h1>Office Space Rentals</h1>;
  const mainImageUrl = offices[0].image;

  return (
    <div style={{ padding: 16 }}>
      {heading}
      <img src={mainImageUrl} alt="Office" width={320} height={180} />

      <h2>Available Spaces</h2>
      <ul>
        {offices.map((o, i) => (
          <li key={i} style={{ marginBottom: 12 }}>
            <div><strong>Name:</strong> {o.name}</div>
            <div>
              <strong>Rent:</strong>{' '}
              <span style={{ color: o.rent < 60000 ? 'red' : 'green' }}>₹{o.rent.toLocaleString('en-IN')}</span>
            </div>
            <div><strong>Address:</strong> {o.address}</div>
          </li>
        ))}
      </ul>
    </div>
  );
}
