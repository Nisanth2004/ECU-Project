import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Message = () => {
    const [message, setMessage] = useState('');

    useEffect(() => {
        axios.get('http://localhost:8080/message')
            .then(response => {
                setMessage(response.data);
            })
            .catch(error => {
                console.error('Error fetching message: ', error);
            });
    }, []);

    return (
        <div>
            <h1>Message from Server:</h1>
            <p>{message}</p>
        </div>
    );
};

export default Message;
