import React from 'react';

export default function BookDetails() {
  const books = [
    { id: 1, title: 'Clean Code', author: 'Robert C. Martin' },
    { id: 2, title: 'Effective Java', author: 'Joshua Bloch' },
  ];
  return (
    <div>
      <h3>Book Details</h3>
      <ul>
        {books.map(b => (
          <li key={b.id}>{b.title} — {b.author}</li>
        ))}
      </ul>
    </div>
  );
}
