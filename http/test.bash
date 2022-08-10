#!/user/bin

curl -H'Content-Type: application/json' -X POST http://localhost:8080/api/v1/posts -d'{"title": "title", "content": "content", "author": "author"}'