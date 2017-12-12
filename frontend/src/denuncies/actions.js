export const CREATE_DENUNCIA = 'CREATE_DENUNCIA';
export function createDenuncia(denuncia){
  return {
    type:CREATE_DENUNCIA,
    denuncia,
  };
}

export const CREATE_DENUNCIA_FULFILLED = 'CREATE_DENUNCIA_FULFILLED';
export function createDenunciaFulfilled(payload){
  return {
    type:CREATE_DENUNCIA_FULFILLED,
    payload,
  };
}

export const FETCH_DENUNCIES = 'FETCH_DENUNCIES';
export function fetchDenuncia(){
  return{
    type: FETCH_DENUNCIES,
  };
}

export const FETCH_DENUNCIES_FULFILLED = 'FETCH_DENUNCIES_FULFILLED';
export function fetchDenunciesFullfilled(payload){
  return {
    type:FETCH_DENUNCIES_FULFILLED,
    payload,
  };
}
