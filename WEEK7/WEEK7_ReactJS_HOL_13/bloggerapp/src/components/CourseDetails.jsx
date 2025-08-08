import React from 'react';

export default function CourseDetails() {
  const courses = [
    { id: 'c1', name: 'React Basics', duration: '4 weeks' },
    { id: 'c2', name: 'Advanced React', duration: '6 weeks' },
  ];
  return (
    <div>
      <h3>Course Details</h3>
      <ul>
        {courses.map(c => (
          <li key={c.id}>{c.name} — {c.duration}</li>
        ))}
      </ul>
    </div>
  );
}
