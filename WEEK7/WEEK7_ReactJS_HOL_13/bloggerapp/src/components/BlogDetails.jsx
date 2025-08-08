import React from 'react';

export default function BlogDetails() {
  const posts = [
    { id: 101, title: 'React Patterns', author: 'Aman' },
    { id: 102, title: 'State Management', author: 'Sharma' },
  ];
  return (
    <div>
      <h3>Blog Details</h3>
      <ul>
        {posts.map(p => (
          <li key={p.id}>{p.title} — {p.author}</li>
        ))}
      </ul>
    </div>
  );
}
