import React, { useState } from 'react';
import ImageGenerator from './components/ImageGenerator';
import HistoryGallery from './components/HistoryGallery';
import './App.css';

function App() {
  const [refresh, setRefresh] = useState(false);

  const handleNewImage = () => {
    setRefresh(!refresh); // toggle to force HistoryGallery to re-fetch
  };

  return (
    <div className="App">
      <header className="app-header">
        <h1>AI Image Generator</h1>
        <p>Generate stunning images from text descriptions</p>
      </header>
      <main>
        <ImageGenerator onNewImage={handleNewImage} />
        <HistoryGallery key={refresh} />
      </main>
    </div>
  );
}

export default App;