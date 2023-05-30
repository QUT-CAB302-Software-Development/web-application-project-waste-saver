% Template for MXB201 Project Part II.
%% Initialisation
clear
d = dir('faces/*.pgm');
N = length(d);
I = imread([d(1).folder, '/', d(1).name]);
[rows,cols] = size(I);
M = rows*cols;
A = zeros(M, N);  % big matrix, whose columns are the images
%% Read images as columns of the matrix
for j = 1:N
    I = imread([d(j).folder, '/', d(j).name]);
    A(:,j) = I(:);
end
%% Calculate and visualise mean face
mean_face = mean(A,2); % return a column vector containing the mean of each row
uint_mean_face = uint8(mean_face); % convert to uint8 for grayscale image
grayscale_img = reshape(uint_mean_face, rows, cols); % reshape into size 192*168 for visualising purpose
imshow(grayscale_img); % image of the mean face
%% Calculate mean-centred SVD
format long % to show closeness of results

mean_d = double(mean_face); % convert back to double for matrix calculation

[U,Sigma,V] = svd(mean_d, 'econ'); % finds the reduced svd of the mean face matrix

decom = (norm(mean_d - U*Sigma*V')); % difference between A and UΣV' is basically zero

U'*U; % U now not being orthogonal still statisfies U'*U = I
%% Visualise first 20 eigenfaces
fir_20 = A(:, 1:20); %% extract the first 20 faces
fir_20 = bsxfun(@minus, fir_20, mean_face); % difference between the mean face and the first twenty faces

% fir_20 is the difference between the first 20 image and the mean_face
% not eigenface, needed to calculate covarience to obtain the eigenvector and eigenvalue
% as the matrix for an image is 32256*1, the covarience will be 32256*32256
% which is too large for the system to handle

faceArray = repmat(I, [ 1 1 20 ]); % create an array of 192x168x20 to represent the first 20 eigenfaces
for i = 1:20
    faceArray(:,:,i) = reshape(fir_20(:,i),[rows cols]); % reshape into size 192*168 for visualising purpose
end
montage(faceArray); % show the first 20 eigenfaces
%% Calculate coordinate vectors
format short
facediff = diag(Sigma); % Our singular values from the SVD 

nu = 20;  % Using the first twenty singular vectors of U
c1 = Sigma(1:nu, 1:nu) * V(1, 1:nu)';  % We can now evaluate the coordinate vector for any column of U

[mean_face(:,1) U(:, 1:nu)*c1]; % The values for the first column of the mean face and the first coordinate vector match approximately
%% Demonstrate rudimentary moustache detector
m_count = 0; % count the amount of moustache image detected
m_index = zeros([1 1000]); % array to record the index of the moustache image
m_img = repmat(I,[1 1 1000]); % create an array of 192x168x20 to represent the images with moustache

for i = 1:1000
    curr = double(reshape(A(:,i),[rows cols])); % reshape the current image into a grayscale image
    diff = double(grayscale_img(120:140, 44:124)) - curr(120:140, 44:124); % mean subtract the current image, so overexposed images will be excluded as the value becomes negative
    diff_avg = sum(diff, "all")/1701; % the average difference (0 to 255, where 0 is similar and 255 is different)
    curr_avg = sum(curr, "all")/M; % average brightness of the entire face
    mous_avg = sum(curr(120:140, 44:124), "all")/1701; % average brightness of the moustache area
    contrast = abs(curr_avg-mous_avg); % difference between entire face and the moustache area
    if diff_avg > 10 & contrast > 10
        m_count = m_count + 1; % increase moustache image count
        m_index(m_count) = i; % record index of the image
    end
end

% this method does not use eigenvector so it might not fulfil the
% requirement of the assignment

for i = 1:m_count
    m_img(:,:,i) = (uint8(reshape(A(:,m_index(i)),[rows cols]))); %% replace the array with the moustache image
end
montage(m_img(:,:,1:m_count)); %% show all image that meets the requirements