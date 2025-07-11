import React from 'react';

interface ToastProps {
  message: string;
  type: 'success' | 'error' | 'warning';
  onClose: () => void;
}

const Toast: React.FC<ToastProps> = ({ message, type, onClose }) => {
  const bgColor = {
    success: 'bg-green-100 border-green-400 text-green-700',
    error: 'bg-red-100 border-red-400 text-red-700',
    warning: 'bg-yellow-100 border-yellow-400 text-yellow-700',
  };

  return (
    <div className={`fixed top-4 right-4 border px-4 py-3 rounded ${bgColor[type]} shadow-lg z-50`}>
      <div className="flex items-center">
        <span className="mr-2">{message}</span>
        <button onClick={onClose} className="text-lg font-bold">&times;</button>
      </div>
    </div>
  );
};

export default Toast;