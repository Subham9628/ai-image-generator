import React, { useEffect, useState } from 'react';
import api from '../api/axiosConfig';
import './HistoryGallery.css';

const HistoryGallery = () => {
  const [history, setHistory] = useState([]);

  const fetchHistory = async () => {
    try {
      const response = await api.get('/images/history');
      setHistory(response.data);
    } catch (err) {
      console.error('Failed to fetch history:', err);
    }
  };

  useEffect(() => {
    fetchHistory();
  }, []);

  return (
    <div className="history-container">
      <h2>History</h2>
      <div className="history-grid">
        {history.length === 0 ? (
          <p>No images generated yet.</p>
        ) : (
          history.map((item) => (
            <div key={item.id} className="history-card">
              <img src={item.imageUrl} alt={item.prompt} />
              <p className="prompt">{item.prompt}</p>
              <p className="timestamp">
                {new Date(item.createdAt).toLocaleString()}
              </p>
            </div>
          ))
        )}
      </div>
    </div>
  );
};

export default HistoryGallery;