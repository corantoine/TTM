import React from 'react'
import { Link } from 'react-router-dom'

const FilProfile = () => {
  return (
    <>
      <h1>Partez à la découverte des profils !</h1>
      <>
        <div className="card-container">
          <div className="profile-card">
            <div className="card-title">
              <div className="pic">PICTURE</div>
              <div className="identity">NOM PRENOM</div>
            </div>
            <Link className="voir-profil" to="/">
              Voir le profil
            </Link>
          </div>
        </div>
      </>
      <div className="card-container">
        <div className="profile-card">
          <div className="card-title">
            <div className="pic">PICTURE</div>
            <div className="identity">oneUser?.lastname oneUser?.firstname</div>
          </div>
          <Link className="voir-profil" to="/">
            Voir le profil
          </Link>
        </div>
      </div>
      <div>TEST</div>
    </>
  )
}

export default FilProfile
// import React from 'react';

// const FilProfile = () => {
//     return (
//         <>
//       <h1>Partez à la découverte des profils !</h1>
//       {currentUser?.role === "[ROLE_PORTEUR]" ? (
//         <>
//           <div className="card-container">
//             {parrains.map((parrain, index) => (
//               <div className="profile-card" key={index}>
//                 <div className="card-title">
//                   <div className="pic">PICTURE</div>
//                   <div className="identity">
//                     {parrain?.lastname} {parrain?.firstname}
//                   </div>
//                 </div>
//                 <Link
//                   className="voir-profil"
//                   to={`/ttm/me/profil/${parrain?.userId}`}
//                 >
//                   Voir le profil
//                 </Link>
//               </div>
//             ))}
//           </div>
//         </>
//       ) : currentUser?.role === "[ROLE_ADMIN]" ? (
//         <div className="card-container">
//           {allUsers.map((oneUser, index) => (
//             <div className="profile-card" key={index}>
//               <div className="card-title">
//                 <div className="pic">PICTURE</div>
//                 <div className="identity">
//                   {oneUser?.lastname} {oneUser?.firstname}
//                 </div>
//               </div>
//               <Link
//                 className="voir-profil"
//                 to={`/ttm/me/profil/${oneUser?.userId}`}
//               >
//                 Voir le profil
//               </Link>
//             </div>
//           ))}
//         </div>
//       ) : (
//         <div>TEST</div>
//       )}
//     </>
//     );
// };

// export default FilProfile;
