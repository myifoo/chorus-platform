# use chrome to send request

XMLHttpRequest:

- 

```javascript
let rest = new XMLHttpRequest()

rest.open("GET", "http://localhost:8080/meta/model/html", true)
rest.send()

rest.open("POST", "http://localhost:8080/admin/json", true)
rest.setRequestHeader("Content-Type", "application/json")
rest.send(JSON.stringify({"message": "hello chorus"}))

```