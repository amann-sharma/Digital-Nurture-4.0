import React, { useState } from 'react';
import BlogDetails from './components/BlogDetails';
import BookDetails from './components/BookDetails';
import CourseDetails from './components/CourseDetails';

export default function App() {
  const [view, setView] = useState('books');
  const showBooks = view === 'books';

  return (
    <div style={{ padding: 16 }}>
      <h1>bloggerapp</h1>

      <div style={{ marginBottom: 12 }}>
        <button onClick={() => setView('books')}>Books</button>
        <button onClick={() => setView('blogs')} style={{ marginLeft: 8 }}>Blogs</button>
        <button onClick={() => setView('courses')} style={{ marginLeft: 8 }}>Courses</button>
      </div>

      {/* Conditional rendering - ternary */}
      {showBooks ? <BookDetails /> : null}

      {/* Conditional rendering - logical AND */}
      {view === 'blogs' && <BlogDetails />}

      {/* Conditional rendering - function switch */}
      {(() => {
        switch (view) {
          case 'courses':
            return <CourseDetails />;
          default:
            return null;
        }
      })()}
    </div>
  );
}
