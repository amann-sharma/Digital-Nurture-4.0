import React from 'react';
import CohortDetails from './components/CohortDetails';

function App() {
  const cohorts = [
    {
<<<<<<< HEAD
      name: "DN4JFSD2024 - Java Full Stack",
      started: "15-Jan-2024",
      status: "Active",
      coach: "Priya Patel",
      trainer: "Rajesh Kumar"
    },
    {
      name: "DN4NET2024 - .NET Development",
      started: "20-Mar-2024",
      status: "In Progress",
      coach: "Amit Singh",
      trainer: "Sarah Johnson"
    },
    {
      name: "DN4PYTHON2024 - Python Development",
      started: "10-May-2024",
      status: "Scheduled",
      coach: "Neha Sharma",
      trainer: "David Chen"
=======
      name: "INTADMDF10 - .NET FSD",
      started: "22-Feb-2022",
      status: "Scheduled",
      coach: "Aathma",
      trainer: "Jojo Jose"
    },
    {
      name: "ADM21JF014 - Java FSD",
      started: "10-Sep-2021",
      status: "Ongoing",
      coach: "Apoorv",
      trainer: "Elisa Smith"
    },
    {
      name: "CDBJF21025 - Java FSD",
      started: "24-Dec-2021",
      status: "Ongoing",
      coach: "Aathma",
      trainer: "John Doe"
>>>>>>> ecee5d83082a822f560f400800c3441d9e0f50ad
    }
  ];

  return (
    <div>
      <h2>Cohorts Details</h2>
      {cohorts.map((c, i) => (
        <CohortDetails cohort={c} key={i} />
      ))}
    </div>
  );
}

export default App;
