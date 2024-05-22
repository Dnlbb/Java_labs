#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <set>
#include <dirent.h>
#include <sys/stat.h>
#include <regex>

bool is_regular_file(const std::string& path) {
    struct stat path_stat;
    lstat(path.c_str(), &path_stat);
    return S_ISREG(path_stat.st_mode);
}

std::vector<std::string> get_html_files(const std::string& directory) {
    std::vector<std::string> html_files;
    DIR* dirp = opendir(directory.c_str());
    struct dirent* dp;
    while ((dp = readdir(dirp)) != nullptr) {
        std::string filename(dp->d_name);
        if (filename.length() >= 5 && filename.substr(filename.length() - 5) == ".html") {
            std::string filepath = directory + "/" + filename;
            if (is_regular_file(filepath)) {
                html_files.push_back(filepath);
            }
        }
    }
    closedir(dirp);
    return html_files;
}

std::string remove_comments(const std::string& html_content) {
    std::regex comment_regex("<!--.*?-->", std::regex_constants::icase | std::regex_constants::nosubs | std::regex_constants::multiline);
    return std::regex_replace(html_content, comment_regex, "");
}


void process_html_files(const std::vector<std::string>& html_files) {
    for (const std::string& filepath : html_files) {
        std::ifstream input_file(filepath);
        std::string html_content((std::istreambuf_iterator<char>(input_file)),
                                 std::istreambuf_iterator<char>());
        input_file.close();
        std::string cleaned_content = remove_comments(html_content);
        std::string filename = filepath.substr(filepath.find_last_of("/\\") + 1);
        std::ofstream output_file(filename);
        output_file << cleaned_content;
        output_file.close();
    }
}

int main(int argc, char* argv[]) {
    std::string directory = argv[1];
    std::vector<std::string> html_files = get_html_files(directory);
    process_html_files(html_files);
    return 0;
}
