SHELL := /bin/zsh

docker/run:
	docker-compose up -d --build

docker/stop:
	docker-compose down

docker/clean:
	docker volume rm journalws_postgres_data
