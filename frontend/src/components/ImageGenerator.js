import React, { useState } from 'react';
import api from '../api/axiosConfig';
import LoadingSpinner from './LoadingSpinner';
import './ImageGenerator.css';

const ImageGenerator = ({ onNewImage }) => {
  const [prompt, setPrompt] = useState('');
  const [imageUrl, setImageUrl] = useState('');
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');

  const generateImage = async () => {
    if (!prompt.trim()) {
      setError('Please enter a prompt');
      return;
    }

    setLoading(true);
    setError('');
    setImageUrl('');


   try {
  const response = await api.post('/images/generate', { prompt });
  const url = response.data.imageUrl;
  setImageUrl(url);
  setError('');          // clear any previous error
  onNewImage();          // refresh history
} catch (err) {
  setError('Failed to generate image. Please try again.');
  console.error(err);
} finally {
      setLoading(false);
    }
  };

  return (
    <div className="generator-container">
      <h2>AI Image Generator</h2>
      <div className="input-group">
        <textarea
          value={prompt}
          onChange={(e) => setPrompt(e.target.value)}
          placeholder="Describe the image you want to generate..."
          rows="3"
        />
        <button onClick={generateImage} disabled={loading}>
          {loading ? 'Generating...' : 'Generate'}
        </button>
      </div>
      {error && <p className="error">{error}</p>}
      {loading && <LoadingSpinner />}
      {imageUrl && (
        <div className="result">
          <img src={imageUrl} alt="Generated" />
          <a href={imageUrl} download="generated-image.png">
            Download
          </a>
        </div>
      )}
    </div>
  );
};

export default ImageGenerator;