#pragma once
#define WIN32_LEAN_AND_MEAN
#include "myexception.h"
#include <ctype.h>
#include <fstream>
#include "BanWord.h"
#include <iostream>
#include <winsock2.h>
#include <ws2tcpip.h>
#include <stdlib.h>
#include <Windows.h>

class MessageModerator {
	friend DWORD WINAPI countBanWords(LPVOID lpParametr);

public:
	std::vector<std::string> getBanWords();
	std::vector<std::string> getMSGWords();
	LONG getTotalNumberOfBanWordsCounter();
	int getMaxNumOfBanWords();
	void setMaxNumOfBanWords(int max);

	bool isSendable();
	void setBanWords(std::vector <std::string> vect);

	MessageModerator(std::string msg, std::vector<std::string> banWords, int maxBanAmount);
	MessageModerator(const MessageModerator& moderator2);
	~MessageModerator();

private:
	void setMessageWords(std::vector < std::string> vect);
	std::vector<std::string> saparateTextIntoWords(std::string str);

	int maxNumOfBanWords;
	LONG totalNumberOfBanWordsCounter;

	std::string message;
	std::vector<std::string> messageWords;
	std::vector<std::string> banWords;

	DWORD* threadsID;
	HANDLE* threadsHandles;
};