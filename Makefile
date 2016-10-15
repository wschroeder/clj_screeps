.PHONY: all release clean clean_all

all: dist/clj.js main.js

dist:
	mkdir -p dist

dist/clj.js: dist out/clj.js
	cp out/clj.js dist/clj.js
	echo 'module.exports = {on_tick: clj_screeps.core.on_tick}' >> dist/clj.js

dist/main.js: dist main.js
	cp main.js dist/main.js

release: node_modules dist/clj.js dist/main.js
	docker run -it --rm -w /work -v ${PWD}:/work mkenney/npm:debian npm run release

out/clj.js: src/**/*.cljs release.clj
	java -cp cljs.jar:src clojure.main release.clj

node_modules: package.json
	docker run -it --rm -w /work -v ${PWD}:/work mkenney/npm:debian npm install

clean:
	rm -rf dist out

clean_all: clean
	rm -rf node_modules

