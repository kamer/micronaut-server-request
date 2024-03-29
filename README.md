Reproducer for https://github.com/micronaut-projects/micronaut-core/issues/10665

# Reproduction steps
- Run project.
- Send the request below:
```shell
curl --location --request POST 'localhost:8080/demo' \
--header 'Content-Type: application/json' \
--data-raw '{
  "name": "Foo",
  "surname": "Bar",
  "attributes": {
    "attr.fred": "Sed mattis, arcu ac rutrum pulvinar, ligula neque consequat dui, et hendrerit augue orci eget ipsum. Nunc blandit neque lacinia mi dapibus, eget maximus ligula viverra.",
    "attr.qux": "496",
    "attr.bar": "Lorem ipsum",
    "attr.garply": "Java",
    "attr.grault": "1.234",
    "attr.foo": "1, 2, 3, 4, 5",
    "attr.quux": "Suspendisse eu justo leo. Integer suscipit, neque ut venenatis mollis, dolor dui malesuada massa, eget porta erat lectus eget velit. Suspendisse pharetra lacus dolor, vitae laoreet mi tempor nec.",
    "attr.corge": "Micronaut",
    "attr.xyzzy": "Long json",
    "attr.baz": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin eleifend massa eu auctor placerat. Aliquam erat volutpat. Maecenas hendrerit cursus tellus, non maximus velit tristique in. Etiam id enim sed ipsum accumsan hendrerit et et nulla. In hac habitasse platea dictumst. Nunc pharetra odio sit amet congue congue. Suspendisse a cursus sapien. Curabitur non gravida nibh.",
    "attr.plugh": "1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13",
    "attr.waldo": "Hello world!"
  },
  "whitelist": [
    "abandoned", "able", "absolute", "adorable", "adventurous", "academic", "acceptable", "acclaimed", "accomplished", "accurate", "aching", "acidic", "acrobatic", "active", "actual", "adept", "admirable", "admired", "adolescent", "adorable", "adored", "advanced", "afraid", "affectionate", "aged", "aggravating", "aggressive", "agile", "agitated", "agonizing", "agreeable", "ajar", "alarmed", "alarming", "alert", "alienated", "alive", "all", "altruistic", "amazing", "ambitious", "ample", "amused", "amusing", "anchored", "ancient", "angelic", "angry", "anguished", "animated", "annual", "another", "antique", "anxious", "any", "apprehensive", "appropriate", "apt", "arctic", "arid", "aromatic", "artistic", "ashamed", "assured", "astonishing", "athletic", "attached", "attentive", "attractive", "austere", "authentic", "authorized", "automatic", "avaricious", "average", "aware", "awesome", "awful", "awkward", "babyish", "bad", "back", "baggy", "bare", "barren", "basic", "beautiful", "belated", "beloved", "beneficial", "better", "best", "bewitched", "big", "bighearted", "biodegradable", "bitesized", "bitter", "black"
  ]
}'
```
- Look at the logs. You should see "HttpRequest empty" error log.
- Same request with shorter json will also work without error. Restart the application and send request below:
```shell
curl --location --request POST 'localhost:8080/demo' \
--header 'Content-Type: application/json' \
--data-raw '{
	"name": "Foo",
	"surname": "Bar",
	"attributes": {
		"attr.foo": "bar"
	},
	"whitelist": [
		"abandoned"
	]
}'
```
