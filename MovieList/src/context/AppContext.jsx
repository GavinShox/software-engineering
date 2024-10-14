import { createContext, useState } from 'react';

// Create the context object
const AppContext = createContext();

const AppProvider = ({ children }) => {
  const [profile, setProfile] = useState({ name: '', email: '', age: '' });

  return (
    <AppContext.Provider value={{ profile, setProfile }}>
      {children}
    </AppContext.Provider>
  );
};

export { AppContext, AppProvider };
