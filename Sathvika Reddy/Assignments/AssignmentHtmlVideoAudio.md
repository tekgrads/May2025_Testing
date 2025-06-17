
# HTML Assignment: Including Videos and Audios

## Objective:
Create a simple HTML webpage that includes embedded audio and video files.

## HTML Code:

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Multimedia Example</title>
</head>
<body>

    <h1>Welcome to the Multimedia Webpage</h1>

    <h2>Embedded Video</h2>
    <video width="600" controls>
        <source src="sample-video.mp4" type="video/mp4">
        Hey here is Video!!
    </video>

    <h2>Embedded Audio</h2>
    <audio controls>
        <source src="sample-audio.mp3" type="audio/mpeg">
        Hey here is audio!!
    </audio>

</body>
</html>
```

## Instructions:
- Replace `"sample-video.mp4"` and `"sample-audio.mp3"` with actual file names.
- Ensure the audio and video files are in the same directory as the HTML file or provide correct paths.

## Output:
The webpage will display:
- A video player with playback controls.
- An audio player with playback controls.
