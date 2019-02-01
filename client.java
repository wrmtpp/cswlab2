var net = require('net');
var HOST = 'coc.waterphuket.com';
var PORT = 6969;
var num = 0;
var i = 0;
var client = new net.Socket();
	client.connect(PORT, HOST, function() {
 	console.log('CONNECTED TO: ' + HOST + ':' + PORT);
 		client.write('5835512115');
	});
	client.on('data', function(data) {
 		console.log('DATA: ' + data);
 		if (data == 'OK')
 		 {client.write('' +  num)}
 		else if(data == 'WRONG') {

 			console.log('WRONG')
 			client.write('' + num);
 			//client.destroy();
 		}
 		else if(data == 'BINGO'){
 			console.log('BINGO')
 			client.destroy();
 		}
 		console.log('num: ' + num);
 		num++;
 		if(i==4)
 		{
 			i=0;
 			client.connect(PORT, HOST, function() {
 			console.log('CONNECTED TO: ' + HOST + ':' + PORT);
 			client.write('5835512115');
	});
 		}
 		i++;



	});
	// Add a 'close' event handler for the client socket
	client.on('close', function() {
 	console.log('Connection closed');
});