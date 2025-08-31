import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import reportWebVitals from './reportWebVitals';
import React from 'react';
import ReactDOM from 'react-dom/client';
import Create from './Create';
import ReadAll from './ReadAll';
import Update from './Update';
import Read from './Read';
import Delete from './Delete';
import App from './App';
import A from './A';
import B from './B';
import NotFound from './NotFound';
const routes = createBrowserRouter([
  { path: '/', element: <App /> },
  { path: '/create', element: <Create /> },
  // { path: '/update', element: <Update /> },
  {path: '/update/:dept/:id', element: <Update />},
  { path: '/readAll', element: <ReadAll /> },
  { path: '/read/:id', element: <Read /> },
  { path: '/delete', element: <Delete /> },
  { path: '/goToA', element: <A/> },
  { path: '/goToB', element: <B/> },
  { path: '*', element: <NotFound/> },
  
]);
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <RouterProvider router={routes} />
  </React.StrictMode>
);
reportWebVitals();