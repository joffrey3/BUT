const loader = {
	count: 0,
	images: {},

	add(title, src) {
		const image = new Image();
		image.src = src;
		this.images[title] = image;
		this.count++;
	},

	init() {
		loader.add('ship', './img/vaisseau.jpg');
		loader.add('alien', './img/alien.jpg');
		loader.add('explosion', './img/explosion.png');
	}
};

