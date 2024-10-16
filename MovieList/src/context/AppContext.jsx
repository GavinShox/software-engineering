import { createContext, useState } from 'react';
import PropTypes from 'prop-types';

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

// validation of children props
AppProvider.propTypes = {
  children: PropTypes.node.isRequired,
};

export { AppContext, AppProvider };
