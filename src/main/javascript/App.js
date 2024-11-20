import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./components/Home";
import Layout from "./components/Layout";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route element={<Layout />}>
          <Route path = "/" element={<Home/>}/>
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;

// PROBLEME EXECUTION REACT ROUTER DOM A REGLER.
