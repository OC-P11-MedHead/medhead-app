// // googlemaps.d.ts

// declare namespace google.maps {

//     interface PlaceResult {
//       // Définissez ici la structure des données que vous souhaitez utiliser
//       // par exemple :
//       formatted_address: string;
//       geometry: {
//         location: {
//           lat(): number;
//           lng(): number;
//         };
//       };
//     }
  
//     interface AutocompletePrediction {
//       // Définissez ici la structure des données que vous souhaitez utiliser
//       // par exemple :
//       description: string;
//       place_id: string;
//     }
  
//     class Autocomplete {
//       constructor(inputField: HTMLInputElement, options?: AutocompleteOptions);
//       addListener(event: string, callback: () => void): void;
//       getPlace(): PlaceResult;
//     }
  
//     interface AutocompleteOptions {
//       types: string[];
//     }
//   }
  