## Week 6 — React Hands-on Labs (HOL)

This week contains 5 React apps built with Create React App. Use the commands below to install and run each app locally for screenshots/demos.

### Prerequisites
- Node.js 18+ (recommended)
- npm (bundled with Node)

Note: If a port is already in use, use a different PORT as shown.

### HOL 1 — myfirstreact
- Path: `WEEK6_ReactJS_HOL_1/myfirstreact`
- Purpose: Introduction to React fundamentals and component structure
- Run:
  - cd `WEEK6_ReactJS_HOL_1/myfirstreact`
  - npm install
  - npm start (opens at http://localhost:3000)

### HOL 2 — studentapp
- Path: `WEEK6_ReactJS_HOL_2/studentapp`
- Purpose: Multi-component React application with routing concepts
- Run:
  - cd `WEEK6_ReactJS_HOL_2/studentapp`
  - npm install
  - PORT=3001 npm start (Mac/Linux)
  - On Windows (PowerShell): `$env:PORT=3001; npm start`
  - App: http://localhost:3001

### HOL 3 — scorecalculatorapp
- Path: `WEEK6_ReactJS_HOL_3/scorecalculatorapp`
- Purpose: React state management and props demonstration
- Run:
  - cd `WEEK6_ReactJS_HOL_3/scorecalculatorapp`
  - npm install
  - PORT=3002 npm start (Mac/Linux)
  - On Windows (PowerShell): `$env:PORT=3002; npm start`
  - App: http://localhost:3002

### HOL 4 — blogapp
- Path: `WEEK6_ReactJS_HOL_4/blogapp`
- Purpose: Fetch and display posts (lifecycle methods, error handling)
- Run:
  - cd `WEEK6_ReactJS_HOL_4/blogapp`
  - npm install
  - PORT=3003 npm start (Mac/Linux)
  - On Windows (PowerShell): `$env:PORT=3003; npm start`
  - App: http://localhost:3003
  - Notes: Fetches posts from `https://jsonplaceholder.typicode.com/posts`

### HOL 5 — cohortstracker
- Path: `WEEK6_ReactJS_HOL_5/cohortstracker`
- Purpose: Components and styling with modules
- Run:
  - cd `WEEK6_ReactJS_HOL_5/cohortstracker`
  - npm install
  - PORT=3004 npm start (Mac/Linux)
  - On Windows (PowerShell): `$env:PORT=3004; npm start`
  - App: http://localhost:3004

### Expected Outputs
Each HOL folder includes an `output.png` showing the expected UI for quick verification.

### Tips
- If the browser does not open automatically, visit the URL manually.
- To stop a dev server, press Ctrl+C in the terminal.
- If `npm install` is slow, try clearing the cache: `npm cache clean --force`.
