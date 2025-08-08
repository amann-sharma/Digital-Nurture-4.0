import React, { useState } from 'react';

export default function App() {
  const [count, setCount] = useState(0);
  const [inr, setInr] = useState('100');
  const [eur, setEur] = useState('');

  function sayHello() { alert('Hello!'); }
  function increment() { setCount(c => c + 1); }
  function decrement() { setCount(c => c - 1); }
  function increaseAndGreet() { increment(); sayHello(); }

  function say(message) { alert(`Message: ${message}`); }

  function handleSyntheticClick(e) {
    e.preventDefault();
    alert('I was clicked');
  }

  function convertToEuro(e) {
    e.preventDefault();
    const valueInInr = parseFloat(inr || '0');
    const converted = valueInInr / 90.0; // approx rate
    setEur(converted.toFixed(2));
  }

  return (
    <div style={{ padding: 16 }}>
      <h1>eventexamplesapp</h1>

      <h2>Counter</h2>
      <div>Value: {count}</div>
      <button onClick={increaseAndGreet}>Increase</button>
      <button onClick={decrement} style={{ marginLeft: 8 }}>Decrement</button>

      <h2 style={{ marginTop: 24 }}>Say Welcome</h2>
      <button onClick={() => say('welcome')}>Say Welcome</button>

      <h2 style={{ marginTop: 24 }}>Synthetic Event</h2>
      <button onClick={handleSyntheticClick}>OnPress</button>

      <h2 style={{ marginTop: 24 }}>CurrencyConvertor</h2>
      <form onSubmit={convertToEuro}>
        <label>
          INR:
          <input type="number" value={inr} onChange={e => setInr(e.target.value)} style={{ marginLeft: 8 }} />
        </label>
        <button type="submit" style={{ marginLeft: 8 }}>Convert</button>
      </form>
      {eur && (
        <p>Euro: €{eur}</p>
      )}
    </div>
  );
}
