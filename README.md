# Discord-Reminder-Bot

## Introduction
This is a simple Discord bot created using Java Discord API (JDA) to help you set and manage reminders within your Discord server.

## Getting Started
### Prerequisites
Before start, make sure you have the following installed:

* Java Development Kit (JDK)8 or higher
* Discord account
* Discord bot token (create bot here [Discord Developer Portal](https://discord.com/developers/applications "open developer portal"))

### Installation
1. Clone repository to your local machine:
   <pre>
     https://github.com/SeaumSiddiqui/Discord-Reminder-Bot.git
   </pre>
2. Open the project in your IDE
3. Configure bot token:
   Replace YOUR_BOT_TOKEN_HERE in the config.properties file with your actual bot token.

## Usage
### Run the bot:
   Execute the "Main" class to start the bot.
   
### Invite the bot to your server:
   <pre>
     https://discord.com/oauth2/authorize?client_id=YOUR_BOT_CLIENT_ID&scope=bot&permissions=YOUR_PERMISSIONS
   </pre>
   Replace YOUR_BOT_CLIENT_ID and YOUR_PERMISSIONS.
   
## Set a reminder:
   In any text channel, use one of the following commands to set a reminder:
   * One-time reminder:
     This will set a reminder for once
      <pre>
        /remindat [time] [message]
      </pre>
      For example:
      <pre>
        /remindat 10:30PM meeting
      </pre>
      The bot will send you a reminder after the time specified
     
   * Daily reminder:
     This will set a reminder for daily
      <pre>
        /remindaily [time] [message]
      </pre>
      For example:
      <pre>
        /remindaily 05:00PM touch some grass
      </pre>
      The bot will send you a reminder every day at the specified time
   
   ## Issues
   Feel free to [create an issue](https://github.com/SeaumSiddiqui/Discord-Reminder-Bot/issues/new "new issue") if encounter any issues or have suggestions for improvement.
   
