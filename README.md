# producer

[![Build Status](https://travis-ci.org/shire-digest/producer.svg?branch=master)](https://travis-ci.org/shire-digest/producer)


;)

## Usage

```bash
$ shire-digest-produce --config my-digest-config.json
```

## Config.json


### Sample

| Name | Description |
|:----:|:-----------:|
| output-directory | digest output directory, divided by date. |
| sites | sites to be crawled. |
| generators | enabled generators. |

```json
{
  "output-directory": "/path/to/my/digest",
  "sites": [
    {
      "url": "http://en.wikipedia.org/wiki/Main_Page",
      "crawler": "en-wikipedia-tfa"
    }
  ],
  "generators": ["simple"]
}
```

## License

Copyright © 2014 hbc

Distributed under the [SMPPL](https://github.com/xhacker/SMPPL/blob/master/SMPPL-Freeware.md) License.
