import React from "react";
import { GlobalProvider } from "./contexts/GlobalContext";
import AgendappRoutes from "./routes";

const App = () => {
  return (
    <GlobalProvider>
      <AgendappRoutes />
    </GlobalProvider>
  );
}

export default App;
