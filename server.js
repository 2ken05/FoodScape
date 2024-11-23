import Hapi from '@hapi/hapi';

const server = Hapi.server({
    port: 9000,
    host: 'localhost',
});

const init = async () => {
    await server.start();
    console.log(`Server berjalan di http://localhost:9000`);
    console.log('API FoodScape');
};

init();
