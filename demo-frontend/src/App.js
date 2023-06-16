import './App.css';
import { getIncrement } from "./service/IncrementService"
import { startPing } from "./service/PingService"

import React, { useState, useEffect } from "react"

const App = () => {

  const [number, setNumber] = useState(0);

  const handlePing = async () => {
    startPing().then(data => console.log(data));
  };

  const handelIncrement = async () => {
    getIncrement().then(data => setNumber(data))

  };

  const loadOnce = () => {
    getIncrement().then(data => setNumber(data))
  };

  useEffect(loadOnce, [])

  return (
    <div className="App">
      <header className="App-header">
        Demo Frontend
      </header>
      <button onClick={handelIncrement}>Increment {number}</button>
      <button onClick={handlePing}>Ping</button>
    </div>
  );
}

export default App;
