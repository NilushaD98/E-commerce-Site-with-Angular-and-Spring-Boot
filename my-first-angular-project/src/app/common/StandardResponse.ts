export class StandardResponse{

    constructor(
        public code: number,
        public message: string,
        public data: object
    ){
    }
}